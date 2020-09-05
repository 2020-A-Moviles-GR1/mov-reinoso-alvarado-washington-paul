/**
 * Universo.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {

   nombreUniverso:{ //nombre del atributo
      type:'String',
      required:true,
      unique:true,
      minLength:10,
      maxLength:25
    },
    antiguedadUniverso:{
      type:'number',
      required:true
    },
    tamanioUniverso:{
      type:'Float',
      required:true 
    },
    minTemperatura:{
      type:'Float',      
      required:true 
    },
    universoPrimario:{
      type:'Boolean',
      required:true
    },

    /*
    Aliens:{//one to many (plural)
      collection: "alien", //referenci al modelo
      via:"universo" //Nombre fk en alien
    }
    */

  },

};

