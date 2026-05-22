# Usar una imagen base de Node.js
FROM node:18-slim

# Directorio de trabajo en el contenedor
WORKDIR /app

# Copiar archivos de dependencias
COPY package*.json ./

# Instalar dependencias
RUN npm install --production

# Copiar el resto del código
COPY . .

# Exponer el puerto
EXPOSE 3030

# Comando para iniciar
CMD ["node", "server.js"]
