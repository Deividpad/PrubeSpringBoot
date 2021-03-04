<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>
	<div class="container">
	   <div class="row">
	     <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
	       <div class="card card-signin my-5">
	         <div class="card-body">
	         <h5 class="card-title text-center" style="background-color: beige;">Bienvenido</h5>
				<form id="form" class="form" action="/login" method="post">
				  <div class="form-group">
				    <label for="LblCotizar">Monto a Cotizar $</label>
				    <input type="number" id= "monto" class="form-control" placeholder="Ingrese el monto" required="required" min="1000000">
				  </div>				  
				  <div class="row">
				    <div class="col text-center">
				      <button type="submit" class="btn btn-primary">Enviar Cotización</button>
				    </div>
				  </div>
				</form>
				</div>
	        </div>
	      </div>
	    </div>
	    <div class="row">
	    <div class="col text-center">
	    	<h2 id="msgError" style="color: #bf3a3a; display:none;">No hay socio disponible.</h2>
	    </div>
	  </div>
	  <br/>
	    <div id="conten-table">
		    <table id="table" class="table">
			  <thead class="thead-dark">
			    <tr>
			      <th scope="col">Socio que Realiza el Préstamo</th>
			      <th scope="col">Cuota Mensual</th>
			      <th scope="col">Pago Total del Crédito</th>
			      <th scope="col">Tasa de Interés Mensual</th>
			    </tr>
			  </thead>
			  <tbody>			    			   
			  </tbody>
			</table>
		</div>
	</div>   		
</body>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<script type="text/javascript">
  
  $("form").submit(function(e){		
  		
        e.preventDefault();
        $("#msgError").css('display', 'none');	
        $("#table tbody").empty();
        
        let monto = $("#monto").val();
        if (monto >0){
	        $.ajax({		        
		        method: "GET",
		        url: "http://localhost:9000/socios/" + monto,		        
		        beforeSend: function () {
		            swal.showLoading();
		        },
		        success: function (e) {
		            swal.close();
            		$("#msgError").css('display', 'none');            
		            if(!!e.id){
		            	socio = e;		
		            	let pt = socio['pagoTotal'] / 1000000;
		            	let temp = parseFloat(pt.toFixed(2) * 1000000);
		            	temp = (new Intl.NumberFormat("es-co").format(temp));                
		                $('#table').append($('<tr>')
						  .append($('<td>').append(socio['socio']))
						  .append($('<td>').append("$" + new Intl.NumberFormat("es-co").format(socio['cuotaMensual'])))
						  .append($('<td>').append("$" + temp))
						  .append($('<td>').append(socio['tasa'] + "%"))					  
						)
		            }
		        },error:function(){
		        	swal.close();
		        	$("#msgError").css('display', 'block');
		        }
		    });
	      
        }else{
        	alert("Debe ser mayor a 0");
        }
    });
    
 
</script>
</html>