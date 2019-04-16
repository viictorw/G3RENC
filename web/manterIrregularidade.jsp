<%-- 
    Document   : manterIrregularidade
    Created on : 23/10/2018, 10:43:57
    Author     : luisg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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


 

        <!-- FIM JavaScript para o formulario-->




        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Irregularidade</title>
    </head>
    <body>

     
        

        <br>
        <br>
        <div class="container"><!--Div centralizadora-->
            <div class="col">
                <div>
                    <h1 class="text-center">Irregularidade - ${operacao} </h1> <hr>  <br><br>

                </div>
            </div>
            <form name="form1" action="ManterIrregularidadeController?acao=confirmarOperacao&operacao=${operacao}" method="post">

                <!--Inicio Tabela-->


                <div class="col-lg-9">
                    <table class="table table-striped">
                        <thead>
                        <tbody>
                        <br>

                            <tr>                            
                    <input type="HIDDEN" min="1" class="form-control" name="id" required id="id" value="${irregularidade.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                        </tr>
                            <tr>
                                <td>Autor</td>
                                <td><input type="text" maxlength="45" data-ls-module="charCounter" placeholder="Autor" class="form-control" autocomplete="off" onkeyup="validare(this,'texto')" name="txtAutor" value="${irregularidade.autor}" required<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td> 
                            </tr>

                            <tr>
                                <td>Descrição</td>
                                <td><input type="text" maxlength="45" data-ls-module="charCounter" placeholder="Descrição da Irregularidade" class="form-control" autocomplete="off" onkeyup="validare(this,'texto')" name="txtDescricao" value="${irregularidade.descricao}" required<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td> 
                            </tr>

                            <tr>
                            <td>Espaco:</td>


                            <td>
                                <select class="form-control" name="idEspacos" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <c:forEach items="${espacos}" var="espaco">
                                    <option value="${espaco.id}" <c:if test="${espaco.id == irregularidade.espaco.id}"> selected</c:if>>${espaco.nome}</option>  
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                        </tbody>
                    </table>
                
                    <input onclick="return validar()" type="submit" name="btnConfirmar"  class="btn btn-outline-primary" role="button" aria-pressed="true" value="Confirmar">
                    
                    <a href="PesquisaIrregularidadeController" class="btn btn-outline-danger" role="button" aria-pressed="true" value="Voltar">Voltar</a>

</div>
                                    </form>
                </div> <!--FIM da Div centralizadora-->

                <hr>
                                <br>
                                <br>
            
                            
                            
      <hr>
                
<!--inicio Footer-->
<%@ include file = "Footer.jsp" %>
<!--fim Footer-->




                </body>
                </html>
