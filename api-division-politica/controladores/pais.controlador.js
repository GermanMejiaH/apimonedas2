const repositorio = require("../repositorios/pais.repositorio");


class PaisControlador {
    async listar(solicitud, respuesta) {
        try {
            const datos = await repositorio.listar();
            return respuesta.json(datos);
        }
        catch (error) {
            return respuesta.status(500).json({ error: "Error al listar los países" });
        }
    }

    async crear(solicitud, respuesta) {
        try {
            const creado = await repositorio.crear(solicitud.body);
            return respuesta.status(201).json(creado);
        }
        catch (error) {
            return respuesta.status(500).json({ error: "Error al crear el país" });
        }
    }

    async actualizar(solicitud, respuesta) {
        try {
            const { id } = solicitud.params;
            const resultado = await repositorio.actualizar(id, solicitud.body);
            if (!resultado || resultado.matchedCount === 0) {
                return respuesta.status(404).json({ error: "País no encontrado" });
            }
            return respuesta.json({ actualizado: resultado.modifiedCount > 0 });
        }
        catch (error) {
            return respuesta.status(500).json({ error: "Error al actualizar el país" });
        }
    }

    async eliminar(solicitud, respuesta) {
        try {
            const { id } = solicitud.params;
            const resultado = await repositorio.eliminar(id);
            if (!resultado || resultado.deletedCount === 0) {
                return respuesta.status(404).json({ error: "País no encontrado" });
            }
            return respuesta.status(204).send();
        }
        catch (error) {
            return respuesta.status(500).json({ error: "Error al eliminar el país" });
        }
    }
}

module.exports = new PaisControlador();
