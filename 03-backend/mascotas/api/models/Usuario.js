/**
 * Usuario.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */
module.exports = {
  tableName:'epn_usuario',
  attributes: {
    cedula:{ //nombre del atributo
      type:'String',
      required:true,
      columnName: 'epn_cedula',
      unique:true,
      minLength:10,
      maxLength:25,
    },
    nombre:{
      type:'String',
      required:true,            
      minLength:3
    },
    correo:{
      type:'String',
      isEmail:true
    },
    estdoCivil:{
      type:'String',
      isIn:['Soltero','Casado','Divorciado','Viudo','Union Libre'],
      defaultsTo:'Soltero'
    },
    password:{
      type:'String',
      regex:/^[a-zA-Z]\w{3,14}$/
    },

    Pokemons:{//one to many (plural)
      collection: "pokemon", //referenci al modelo
      via:"usuario" //Nombre fk en pokemon
    }

  },
};