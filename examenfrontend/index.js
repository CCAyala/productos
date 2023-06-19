$(document).ready(function(){
    // solicitud para listar 

    $('#listar').on('click', function(){
        event.preventDefault();

        let tabla= document.querySelector('#tabla')
        tabla.innerHTML=''
        $.ajax({

            url :"http://localhost:8080/listarProductos",
            type: "GET",
            dataType: "JSON",
            success: function(entrada){
                tabla.innerHTML ='';
                for(i=0; i< entrada.length;i++){
                    tabla.innerHTML += '<tr><td>'+ entrada[i].referencia+
                    '</td><td>'+ entrada[i].nombre+
                    '</td><td>'+ entrada[i].categoria+
                    '</td><td>'+ entrada[i].precio_unitario+
                    '</td><td>' + entrada[i].cantidad+
                    '</td><td>' + entrada[i].descuento+
                    '</td><td>' + entrada[i].total+
                    '</td><tr>';
                    
                }
            },
            error:function(xhr,textStatus,errorThrown){
              console.log("error",errorThrown);
            }

        })
    })

    //funcion crear

    $('#agregar').on('click',function(){

        let datos={

            referencia:parseInt($('#referencia').val()),
            nombre:$('#nombre').val(),
            categoria:$('#categoria').val(),
            precio_unitario:parseFloat($('#precio_unitario').val()),
            cantidad:parseInt($('#cantidad').val()),
            

        }
        let enviarDatos = JSON.stringify(datos);
        $.ajax({
            url:"http://localhost:8080/agregarProducto",
            type: "POST",
            data: enviarDatos,
            contentType:"application/json",
            dataType:'json',
            success:function(resouesta){
                alert('el producto se ah agregado con exito')
                $('#agregarModal').modal('hide');
            }, error:function(xhr,textStatus,errorThrown){
               
               alert(xhr.responseJSON.error);
        

            }
        })
    })
})