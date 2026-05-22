const express = require("express")
const controlador = require("../controladores/pais.controlador")
const validador = require("../validadores/pais.validador")

class PaisRutas {
    constructor() {
        this.enrutador = express.Router();
        this._configurarRutas();
    }


    _configurarRutas() {
        /**
        * @swagger
        * /api/paises:
        *   get:
        *     summary: Obtiene todos los países
        *     tags:
        *       - Países
        *     responses:
        *       200:
        *         description: Lista de países
         */
        this.enrutador.get("/", (solicitud, respuesta) => controlador.listar(solicitud, respuesta));

        /**
        * @swagger
        * /api/paises:
        *   post:
        *     summary: Crea un país
        *     tags:
        *       - Países
        *     requestBody:
        *       required: true
        *       content:
        *         application/json:
        *           schema:
        *             type: object
        *             properties:
        *               id:
        *                 type: integer
        *               nombre:
        *                 type: string
        *               continente:
        *                 type: string
        *               tipoRegion:
        *                 type: string
        *               codigoAlfa2:
        *                 type: string
        *               codigoAlfa3:
        *                 type: string
        *     responses:
        *       201:
        *         description: País creado
        */
        this.enrutador.post("/", validador.validarCrear, (solicitud, respuesta) => controlador.crear(solicitud, respuesta));

        /**
        * @swagger
        * /api/paises/{id}:
        *   put:
        *     summary: Actualiza un país por id
        *     tags:
        *       - Países
        *     parameters:
        *       - in: path
        *         name: id
        *         required: true
        *         schema:
        *           oneOf:
        *             - type: integer
        *             - type: string
        *     requestBody:
        *       required: true
        *       content:
        *         application/json:
        *           schema:
        *             type: object
        *     responses:
        *       200:
        *         description: País actualizado
        *       404:
        *         description: País no encontrado
        */
        this.enrutador.put("/:id", validador.validarActualizar, (solicitud, respuesta) => controlador.actualizar(solicitud, respuesta));

        /**
        * @swagger
        * /api/paises/{id}:
        *   delete:
        *     summary: Elimina un país por id
        *     tags:
        *       - Países
        *     parameters:
        *       - in: path
        *         name: id
        *         required: true
        *         schema:
        *           oneOf:
        *             - type: integer
        *             - type: string
        *     responses:
        *       204:
        *         description: Eliminado sin contenido
        *       404:
        *         description: País no encontrado
        */
        this.enrutador.delete("/:id", (solicitud, respuesta) => controlador.eliminar(solicitud, respuesta));
    }

    get getEnrutador() {
        return this.enrutador;
    }
}

module.exports = new PaisRutas().getEnrutador;
