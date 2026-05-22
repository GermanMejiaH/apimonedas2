module.exports = {
    SERVIDOR: process.env.DB_HOST || 'mongo',
    PUERTO: process.env.DB_PORT || '27017',
    BASEDATOS: process.env.DB_NAME || 'divisionpolitica',
    USUARIO: process.env.DB_USER || '',
    CLAVE: process.env.DB_PASS || '',
    URI: process.env.DB_URI || '',

    get url() {
        if (this.URI) return this.URI;
        const auth = this.USUARIO && this.CLAVE ? `${this.USUARIO}:${this.CLAVE}@` : '';
        return `mongodb://${auth}${this.SERVIDOR}:${this.PUERTO}`;
    }
}
