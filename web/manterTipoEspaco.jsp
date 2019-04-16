                         
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


        <style>
            footer{
                bottom: 0;
                position: absolute; 
                bottom: 0; 
                left: 0px; 
                right: 0px;
                width: 100%;
                text-align: center;
            }
        </style>
        <script language="javascript"  type="text/javascript" src="js/scriptJSP.js"></script>

        <!-- INICIO JavaScript para o formulario-->

      
        <!-- FIM JavaScript para o formulario-->

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Tipo Espa�o - ${operacao}</title>




    </head>
    <body>






        <br>
        <div class="container">
            <div class="col-lg-12">
                <div>
                    <h1 class="text-center"> Manter Tipo Espaco - ${operacao} </h1> <hr>  <br><br>

                </div>
            </div>


            <form name="form1" action="ManterTipoEspacoController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterTipoEspaco">


                <table class="table table-striped">
                    <thead>
                    <tbody>
                    <br>

                    <tr>
                    <input type="HIDDEN" min="1" class="form-control" name="id" required id="id" value="${tipoEspaco.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>

                  
                        </tr>
                        <tr>
                            <td>Tipo Espa�o</td>
                            <td><input type="text" onkeyup="validare(this, 'texto')" data-ls-module="charCounter"    placeholder="Digite o tipo de espa�o" autocomplete="off"  maxlength="45"   class="form-control" name="txtNome" value="${tipoEspaco.nome}"required<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <td>Modalidade:</td>
                        <td>
                            <select class="form-control" name="optModalidade" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <c:forEach items="${modalidades}" var="modalidade">
                                <option value="${modalidade.id}" <c:if test="${modalidade.id == tipoEspaco.modalidade.id}"> selected</c:if>>${modalidade.id}</option>  
                            </c:forEach>
                        </select>
                    </td>
                    </tr>

                    </tbody>
                </table>


                <input onclick="return validar()" type="submit" name="btnConfirmar"  class="btn btn-outline-primary" role="button" aria-pressed="true" value="Confirmar">

                <a href="PesquisaTipoEspacoController" class="btn btn-outline-danger" role="button" aria-pressed="true" value="Voltar">Voltar</a>

            </form>

        </div>      
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>



        <hr>

        <!--inicio Footer-->
        <%@ include file = "Footer.jsp" %>
        <!--fim Footer-->




    </body>
</html>


