const {Schema, model} = require("mongoose");

const usuarioSchema = new Schema({
    nombre:     { type: String },
    apellidos:  { type: String },
    telefono:   { type: String },
    email:      { type: String }
});

module.exports = model('Usuario', usuarioSchema);