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

        <title>Disponibilidades</title>

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
                            <h1 class="text-center">Lista de Disponibilidades</h1><hr>  <br><br>
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
                                            $("#myTable ${disponibilidade.data}").filter(function () {
                                                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
                                            });
                                        });
                                    });
                                </script>
                            </div>
                        </div>
                    </div>
                    <!-- FIM TAG para buscar -->

                    <!--INICIO Tabela botoes incluir e voltar-->

                    <div class="container">
                        <div class="row">                                   
                            <div class="col-lg">
                                <label>
                                    <form action="ManterDisponibilidadeController?acao=prepararOperacao&operacao=Incluir" method="post">
                                        <input type="submit" name="btnIncluir" class="btn btn-outline-primary btn-sm" value="Incluir">
                                    </form>
                                </label>
                                <!--  Inicio Bot�o de relat�rio -->
                        <a href="#" class="btn btn-outline-primary btn-sm" data-toggle="modal" data-target="#modalEspaco">Relatorios</a>
                    </div>
                    <div class="modal fade" id="modalEspaco" tabindex="-1" role="dialog">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5>
                                        Relatorio completo
                                    </h5>
                                    <div>
                                        <a href="ReportDisponibilidade" class="btn btn-outline-primary btn-sm">Emitir Relat�rio</a>
                                    </div> 
                                </div>
                                <div class="modal-body">
                                    <h5>
                                        Escolha a cidade desejada
                                    </h5>
                                   <form action="ReportDisponibilidadeParam" method="POST" autofocus>
                                        <select class="form-control" name="paramDisponibilidade">

                                            <c:forEach items="${disponibilidades}" var="disponibilidade">
                                                <option value="${disponibilidade.dataDisponivel}">${disponibilidade.dataDisponivel}</option>  
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
                                
                            </div>
                        </div>
                    </div>                            

                    <!--FIM Tabela botoes incluir e voltar-->
                    <!--Tabela-->

                    <div clas="card">
                        <div class="card-body">
                            <c:forEach items="${disponibilidades}" var="dispon">


                                <table class="table table-striped" id="myTable">
                                    </thead>
                                    <tbody>


                                        <tr>
                                            <th colspan="1">
                                                Data dispon�vel : <c:out value ="${dispon.dataDisponivel} de ${dispon.hora_inicio} a ${dispon.hora_fim}"/>
                                            </th>

                                            <th colspan="1">
                                                <a href="ManterDisponibilidadeController?acao=prepararOperacao&operacao=Editar&id=<c:out value="${dispon.id}"/>"
                                                   class="btn btn-outline-success" role="button" aria-pressed="true">Editar</a>
                                                <a href="ManterDisponibilidadeController?acao=prepararOperacao&operacao=Excluir&id=<c:out value="${dispon.id}"/>"
                                                   class="btn btn-outline-danger" role="button" aria-pressed="true">Excluir</a>
                                            </th>

                            






                                    </tbody>

                                </table>


                                <hr>
                            </c:forEach>






                            <!--INICIO Tabela botoes incluir e voltar-->

                            <div class="container">
                                <div class="row">
                                    <div class="col-lg">
                                        <label>
                                            <form action="ManterDisponibilidadeController?acao=prepararOperacao&operacao=Incluir" method="post">
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


                  
                            
                            
      <hr>
                
<!--inicio Footer-->
<%@ include file = "Footer.jsp" %>
<!--fim Footer-->




                    </body>
                    </html>


