const express = require("express");
const morgan = require("morgan");
const mongoose = require('mongoose');

const app = express();

const Usuario = require("./models/Usuario");

mongoose.connect('mongodb://localhost:27017/agenda', {useNewUrlParser: true, useUnifiedTopology: true});

//middlewares
app.use(morgan('dev'));
app.use(express.urlencoded({extended: false})); //uso de formularios
app.use(express.json());

//routes
app.get('/usuarios', async (req,res) => {
    const usuarios = await Usuario.find();
    res.json(usuarios);
    //res.json(await Usuario.find());
});

app.get('/usuarios/:id', async (req,res) => {
    res.json(await Usuario.findById(req.params.id));
});

app.post('/usuarios', async (req,res) => {
    const { nombre, apellidos, telefono, email } = req.body;

    const usuario = new Usuario({ nombre, apellidos, telefono, email });

    res.json(await usuario.save());
});

app.put('/usuarios/:id', async (req,res) => {
    const { nombre, apellidos, telefono, email } = req.body;

    res.json(await Usuario.findByIdAndUpdate(req.params.id, { nombre, apellidos, telefono, email }));
});

app.delete('/usuarios/:id', async (req,res) => {
    res.json(await Usuario.findByIdAndDelete(req.params.id));
});


app.listen(3000, () => {
    console.log("Estoy escuchando por el puerto 3000");
});
