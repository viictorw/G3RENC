                                                           
<%-- 
    Document   : manterAdmin
    Created on : 23/10/2018, 09:43:17
    Author     : viict
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">



        <!-- Bootstrap core CSS -->

        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/modern-business.css" rel="stylesheet">
            
<!--inicio Header-->
<%@ include file = "Header.jsp" %>
<!--fim Header-->

       
     

<script language="javascript"  type="text/javascript" src="js/scriptJSP.js"></script>
        <!-- INICIO JavaScript para o formulario-->



        <!-- FIM JavaScript para o formulario-->


        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Cart�o - ${operacao}</title>


        <!-- JavaScript pasta ( js/scriptJSP.js  )-->
        <script language="javascript"  type="text/javascript" src="js/scriptJSP.js">
        </script>

        <!--inicio Header-->
        <%@ include file = "Header.jsp" %>
        <!--fim Header-->


    </head>
    <body>

      
      
        

        <br>
        <div class="container">
            <div class="col-lg-12">
                <div>
                    <h1 class="text-center"> Cartao - ${operacao} </h1> <hr>  <br><br>

                </div>
            </div>


            <form name="form1"action="ManterCartaoController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterCartao">


                <table class="table table-striped">
                    <thead>
                    <tbody>
                    <br>
                    <tr>
                        <!--<td>C�digo do cartao: </td>-->
                        <input type="HIDDEN"   min="1" onkeyup="validare(this, 'numero')" placeholder="Digite apenas numeros"  required="required" maxlength="9"  autocomplete="off" max="999999999"  class="form-control" name="id" value="${cartao.id}"  required autofocus<c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                        </tr>
                        <tr>
                            <td>Bandeira do cartao: </td>
                            <td><input type="text" class="form-control"  maxlength="45" placeholder="Bandeira" required="required" data-ls-module="charCounter"autocomplete="off"  name="txtBandeiraCartao" value="${cartao.bandeira}" required<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td>Validade do cartao: </td>
                            <td><input type="text"  class="form-control" maxlength="4" placeholder="00/00" required="required" onkeyup="validare(this, 'numero')" autocomplete="off" name="txtValidadeCartao" value="${cartao.validade}" required<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td>N�mero do cartao: </td>
                            <td><input type="text" data-ls-module="charCounter" placeholder="0000.0000" required="required"  autocomplete="off"  class="form-control" name="txtNumeroCartao" maxlength="9" min="1" max="99999999" value="${cartao.numeroCartao}" required<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        </td>
                        </tr>
                        <tr>
                            <td>Codigo do cartao: </td>
                            <td><input type="text" class="form-control" maxlength="3" placeholder="000" onkeyup="validare(this, 'numero')" autocomplete="off" name="txtCodCartao" required="required" value="${cartao.codigoSeguranca}" required<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <td>Cliente:</td>
                        <td>
                            <select class="form-control"  name="idClientes" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <c:forEach items="${clientes}" var="cliente">
                                <option value="${cliente.id}" <c:if test="${cliente.id == cartao.cliente.id}"> selected</c:if>>${cliente.nome}</option>  
                            </c:forEach>
                        </select>
                    </td>

                    </tbody>
                </table>


                <input type="submit" onclick="return validar()" name="btnConfirmar"  class="btn btn-outline-primary" role="button" aria-pressed="true" value="Confirmar">

                <a href="PesquisaCartaoController" class="btn btn-outline-danger" role="button" aria-pressed="true" value="Voltar">Voltar</a>
        </div>
            </form>


        </div>        <!--FIM Div centralizadora-->



        <hr>
                
<!--inicio Footer-->
<%@ include file = "Footer.jsp" %>
<!--fim Footer-->



    </body>
</html>