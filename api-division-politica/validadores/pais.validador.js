function esEnteroPositivo(v) {
  const n = Number(v);
  return Number.isInteger(n) && n >= 0;
}

function normalizarEntrada(body) {
  const result = {};
  if (body.id !== undefined) result.id = esEnteroPositivo(body.id) ? Number(body.id) : body.id;
  if (body.nombre !== undefined) result.nombre = String(body.nombre).trim();
  if (body.continente !== undefined) result.continente = String(body.continente).trim();
  if (body.tipoRegion !== undefined) result.tipoRegion = String(body.tipoRegion).trim();
  if (body.codigoAlfa2 !== undefined) result.codigoAlfa2 = String(body.codigoAlfa2).trim().toUpperCase();
  if (body.codigoAlfa3 !== undefined) result.codigoAlfa3 = String(body.codigoAlfa3).trim().toUpperCase();
  return result;
}

function validarCamposRequeridos(body) {
  const errores = [];
  if (body.id === undefined || !esEnteroPositivo(body.id)) errores.push('id debe ser un entero positivo');
  if (body.nombre === undefined || String(body.nombre).trim().length === 0) errores.push('nombre es requerido');
  if (body.continente === undefined || String(body.continente).trim().length === 0) errores.push('continente es requerido');
  if (body.tipoRegion === undefined || String(body.tipoRegion).trim().length === 0) errores.push('tipoRegion es requerido');
  if (body.codigoAlfa2 === undefined || String(body.codigoAlfa2).trim().length !== 2) errores.push('codigoAlfa2 debe tener 2 caracteres');
  if (body.codigoAlfa3 === undefined || String(body.codigoAlfa3).trim().length !== 3) errores.push('codigoAlfa3 debe tener 3 caracteres');
  return errores;
}

function validarCamposOpcionales(body) {
  const errores = [];
  if (body.id !== undefined && !esEnteroPositivo(body.id)) errores.push('id debe ser un entero positivo');
  if (body.nombre !== undefined && String(body.nombre).trim().length === 0) errores.push('nombre no puede ser vacío');
  if (body.continente !== undefined && String(body.continente).trim().length === 0) errores.push('continente no puede ser vacío');
  if (body.tipoRegion !== undefined && String(body.tipoRegion).trim().length === 0) errores.push('tipoRegion no puede ser vacío');
  if (body.codigoAlfa2 !== undefined && String(body.codigoAlfa2).trim().length !== 2) errores.push('codigoAlfa2 debe tener 2 caracteres');
  if (body.codigoAlfa3 !== undefined && String(body.codigoAlfa3).trim().length !== 3) errores.push('codigoAlfa3 debe tener 3 caracteres');
  const claves = Object.keys(body);
  if (claves.length === 0) errores.push('se requiere al menos un campo para actualizar');
  return errores;
}

function validarCrear(req, res, next) {
  const normalizado = normalizarEntrada(req.body || {});
  const errores = validarCamposRequeridos(normalizado);
  if (errores.length > 0) return res.status(400).json({ errores });
  req.body = normalizado;
  next();
}

function validarActualizar(req, res, next) {
  const normalizado = normalizarEntrada(req.body || {});
  const errores = validarCamposOpcionales(normalizado);
  if (errores.length > 0) return res.status(400).json({ errores });
  req.body = normalizado;
  next();
}

module.exports = {
  validarCrear,
  validarActualizar
};
