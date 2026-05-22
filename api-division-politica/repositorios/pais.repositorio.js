const bd = require("./bd");

class PaisRepositorio {
    constructor() {
        this.collectionName = 'paises';
    }

    get _collection() {
        return bd.getDB().collection(this.collectionName);
    }

    async listar() {
        try {
            return await this._collection
                .find()
                .project({ id: 1, nombre: 1, continente: 1, tipoRegion: 1, codigoAlfa2: 1, codigoAlfa3: 1 })
                .toArray();
        }
        catch (error) {
            this._handleError('listar', error);
        }
    }

    async crear(datos) {
        try {
            await this._collection.insertOne(datos);
            return datos;
        } catch (error) {
            this._handleError('crear', error);
        }
    }

    async actualizar(id, datos) {
        try {
            const filtro = { id: this._parseId(id) };
            const { matchedCount, modifiedCount } = await this._collection.updateOne(filtro, { $set: datos });
            return { matchedCount, modifiedCount };
        } catch (error) {
            this._handleError('actualizar', error);
        }
    }

    async eliminar(id) {
        try {
            const filtro = { id: this._parseId(id) };
            const { deletedCount } = await this._collection.deleteOne(filtro);
            return { deletedCount };
        } catch (error) {
            this._handleError('eliminar', error);
        }
    }

    _handleError(metodo, error) {
        console.error(`Error en repositorio PAIS en el método ${metodo}: ${error.message}`);
        throw error;
    }

    _parseId(id) {
        const n = Number(id);
        return Number.isNaN(n) ? id : n;
        }
}

module.exports = new PaisRepositorio();
