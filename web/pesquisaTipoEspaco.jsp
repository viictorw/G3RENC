
<%--
  Created by IntelliJ IDEA.
  User: viict
  Date: 09/10/2018
  Time: 09:50
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
    <head>
        
        <!-- include para pesquisa funcionar -->
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- fim da nova include -->

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
                position: relative; 
                bottom: 0; 
                left: 0px; 
                right: 0px;
                width: 100%;
                text-align: center;
            }
        </style>

        <title>Tipo Espa�o</title>

    </head>
    <body>

        


        <!-- Corpo da Pagina -->
        <div class="container">

            <!--Inicio Tabela-->

            <div class="col-lg-12">
                <table class="table table-striped">
                    <thead>
                    <br>
                    <div class="col">
                        <div>
                            <h1 class="text-center">Lista de Tipos de Espacos</h1><hr>  <br><br>
                        </div>
                    </div>
                    </thead>
                    
                    <!-- INICIO TAG para buscar -->
                    <div class="container">
                        <div class="row">
                            <div class="col-md-12">
                                <input type="text" id="myInput" onkeyup="myFunction()" class="form-control" placeholder="Pesquisa">
                                <script>
                                    $(document).ready(function () {
                                        $("#myInput").on("keyup", function () {
                                            var value = $(this).val().toLowerCase();
                                            $("#myTable ${tipoEspaco.nome}").filter(function () {
                                                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
                                            });
                                        });
                                    });
                                </script>
                            </div>
                        </div>
                    </div>
                    <!-- FIM TAG para buscar -->
                    <!--INICIO Tabela botoes incluir-->

                    <div class="container">
                        <div class="row">                                   
                            <div class="col-lg">
                                <label>
                                    <form action="ManterTipoEspacoController?acao=prepararOperacao&operacao=Incluir" method="post">
                                        <input type="submit" name="btnIncluir" class="btn btn-outline-primary btn-sm" value="Incluir">
                                    </form>
                                </label>
                        

                    <!--FIM Tabela botoes incluir-->
                    
  <!--  Inicio Bot�o de relat�rio -->
                        <a href="#" class="btn btn-outline-primary btn-sm" data-toggle="modal" data-target="#modalAdmin">Relatorios</a>
                    </div>
                    <div class="modal fade" id="modalAdmin" tabindex="-1" role="dialog">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5>
                                        Relatorio completo
                                    </h5>
                                    <div>
                                        <a href="ReportTipoEspaco" class="btn btn-outline-primary btn-sm">Emitir Relat�rio</a>
                                    </div> 
                                </div>
                                <div class="modal-body">
                                    <h5>
                                        Escolha por tipo
                                    </h5>
                                    <form action="ReportTipoEspacoParam" method="POST" autofocus>
                                        <select class="form-control" name="paramTipoEspaco">

                                            <c:forEach items="${tiposEspacos}" var="tipoEspaco">
                                                <option value="${tipoEspaco.nome}">${tipoEspaco.nome}</option>  
                                            </c:forEach>
                                        </select>
                                        <input class="btn btn-outline-primary btn-sm" type="submit" value="Emitir Relat�rio com Par�metro"/>
                                    </form>
                                </div>
                                <div class="modal-footer">
                                </div>
                            </div>
                        </div>                         
                        <!--  Fim Bot�o de relat�rio -->
                        
                    <!--INICIO Tabela botoes incluir e voltar-->

                    <div class="container">
                        <div class="row">                                   
                            <div class="col-lg">
                                <label>
                                    <form action="ManterTipoEspacoController?acao=prepararOperacao&operacao=Incluir" method="post">
                                        <input type="submit" name="btnIncluir" class="btn btn-outline-primary btn-sm" value="Incluir">
                                    </form>
                                </label>


                            </div>
                        </div>
                    </div>                            

                    <!--FIM Tabela botoes incluir e voltar-->
                    <tr>
                        <!--Tabela-->
                    <div clas="card">
                        <div class="card-body">
                            <c:forEach items="${tiposEspacos}" var="tipoEspaco">

                                <table class="table table-striped" id="myTable">
                                    </thead>
                                    <tbody>

                                   
                                        
                                        
                                        <tr>
                                            <th colspan="1">
                                                Tipo de Espa�o : <c:out value ="${tipoEspaco.nome}"/>
                                            </th>

                                            <th colspan="1">
                                                <a href="ManterTipoEspacoController?acao=prepararOperacao&operacao=Editar&id=<c:out value="${tipoEspaco.id}"/>"
                                                   class="btn btn-outline-success" role="button" aria-pressed="true">Editar</a>
                                                <a href="ManterTipoEspacoController?acao=prepararOperacao&operacao=Excluir&id=<c:out value="${tipoEspaco.id}"/>"
                                                   class="btn btn-outline-danger" role="button" aria-pressed="true">Excluir</a>
                                            </th>

                                        </tr>

                                  </tbody>

                                </table>


                                <hr>
                            </c:forEach>

                            <!--INICIO Tabela botoes incluir e voltar-->

                            <div class="container">
                                <div class="row">
                                    <div class="col-lg">
                                        <label>
                                            <form action="ManterTipoEspacoController?acao=prepararOperacao&operacao=Incluir" method="post">
                                                <input type="submit" name="btnIncluir" class="btn btn-outline-primary btn-sm" value="Incluir">
                                            </form>
                                        </label>


                                    </div>
                                </div>
                            </div>

                            <!--FIM Tabela botoes incluir e voltar-->
                        </div>
                    </div>



                            
                            
      <hr>
                
<!--inicio Footer-->
<%@ include file = "Footer.jsp" %>
<!--fim Footer-->




                    </body>
                    </html>


