/**
 * Aliens.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */


module.exports = {

    attributes: {

      razaAlien:{ //nombre del atributo
        type:"string"
      },
      alturaAlien:{
        type:'Float',
        required:true
      },
      pesoAlien:{
        type:'Float',
        required:true 
      },
      edadAlien:{
        type:'number',      
        required:true 
      },
      ostilidadAlien:{
        type:'Boolean',
        required:true
      },
      nombreUniverso:{ 
        type:'String',
        required:true,
        unique:false,
        minLength:10,
        maxLength:25
      }
    /*  universo:{             //Many to One en Alien.
        model:"universo",    //referencia a universo
        required:true       //opcional y depende de la logica de negocio
      }
    */
  },

};

