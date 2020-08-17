/**
 * Batalla.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    nombre:{
      type:"string"
    },
    Pokemons:{//one to many (plural)
      collection: "pokemon", //referenci al modelo
      via:"batalla", //Nombre fk en pokemon
      required:false
    }
  },
};