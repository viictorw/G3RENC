
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

        <%@ include file = "Header.jsp" %>


        <!-- Adicionando Javascript -->
      
        

        <!-- INICIO JavaScript para o formulario-->
      

        
          <script language="javascript"  type="text/javascript" src="js/scriptJSP.js"></script>

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

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Gerencia Espaço - ${operacao}</title>
    </head>

    <body>




        <br>
        <div class="container"><!--Div centralizadora-->
            <div class="col">
                <div>
                    <h1 class="text-center"> Espaço - ${operacao} </h1> <hr>  <br><br>

                </div>
            </div>      

            <form name="form1"action="ManterEspacoController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterEspaco">


                <!--Inicio Tabela-->

                <div class="col-lg-12">
                    <table class="table table-striped">

                        <tbody>
                        <br>

                        <tr>
                        <input type="HIDDEN" min="1" class="form-control" name="id" required id="id" value="${espaco.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>

                            </tr>
                            <tr>
                                <td>Nome do Espaço</td>
                                <td><input type="text" maxlength="45" placeholder="Nome do Local" data-ls-module="charCounter" class="form-control" autocomplete="off" name="txtNome"value="${espaco.nome}" required<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>CNPJ</td>
                                <td><input type="text" maxlength="9" placeholder="00.000.000"class="form-control" onkeyup="validare(this, 'numero')" autocomplete="off" name="txtCnpj"  value="${espaco.cnpj}" required<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>Cep</td>
                                <td><input type="number" placeholder="00000-000" id="cep" class="form-control" onkeyup="validare(this, 'numero')" autocomplete="off" name="txtCep"  value="${espaco.cep}" required<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>Logradouro</td>
                                <td><input type="text" id="rua" placeholder="Endereço local" data-ls-module="charCounter" maxlength="45" class="form-control"  name="txtLogradouro" autocomplete="off" value="${espaco.logradouro}" required<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>                     
                                <td>Numero</td>
                                <td><input type="text" data-ls-module="charCounter" min="1" max="999999999" placeholder="Nº do local" maxlength="9" class="form-control" onkeyup="validare(this, 'numero')" autocomplete="off" name="txtNumero" value="${espaco.numero}" required<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>Complemento</td>
                                <td><input type="text" placeholder="Complemento" data-ls-module="charCounter"  maxlength="45" class="form-control" name="txtComplemento" autocomplete="off"  value="${espaco.complemento}" required<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>Bairro</td>
                                <td><input type="text" placeholder="Bairro"  id="bairro"  data-ls-module="charCounter"  maxlength="45" size="60" onkeyup="validare(this, 'texto')" class="form-control" autocomplete="off" name="txtBairro" value="${espaco.bairro}" required<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>Cidade</td>
                                <td><input type="text" placeholder="Cidade"  id="cidade"  data-ls-module="charCounter" maxlength="45" onkeyup="validare(this, 'texto')" class="form-control" autocomplete="off" name="txtCidade" value="${espaco.cidade}" required<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>Uf</td>
                                <td><input type="text" placeholder="Estado" data-ls-module="charCounter"  id="uf" maxlength="2" onkeyup="validare(this, 'texto')" class="form-control" autocomplete="off" name="txtUf"  value="${espaco.uf}" required<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>Area</td>
                                <td><input type="text" data-ls-module="charCounter" maxlength="9" min="1" max="999999999" placeholder="M²(mestro quadrado)" onkeyup="validare(this, 'numero')" class="form-control"  autocomplete="off" name="txtArea" size="60" value="${espaco.area}" required<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>Quantidade  de pessoas</td>
                                <td><input type="text" data-ls-module="charCounter" maxlength="9" min="1" max="999999999"  placeholder="Quantidade de pessoas suportadas" onkeyup="validare(this, 'numero')" autocomplete="off" class="form-control" name="txtQuantidadePessoas" size="60" value="${espaco.quantidadePessoas}" required<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>Horario de funcionamento - Inicio</td>
                                <td><input type="time"   class="form-control" maxlength="8" pattern="[0-9]{2}:[0-9]{2} [0-9]{2}$"  autocomplete="off" name="txtHoraFuncionamentoInicio" size="60" value="${espaco.horaFuncionamentoInicio}" required<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>Horario de funcionamento - Fim</td>
                                <td><input type="time"   class="form-control" maxlength="8" pattern="[0-9]{2}:[0-9]{2} [0-9]{2}$" autocomplete="off" name="txtHoraFuncionamentoFinal" value="${espaco.horaFuncionamentoFinal}" required<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>



                            <td>Tipo Espaco:</td>
                            <td>
                                <select class="form-control" name="optTipoEspaco" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>

                                <c:forEach items="${tiposEspacos}" var="tipoEspaco">
                                    <option value="${tipoEspaco.id}" <c:if test="${tipoEspaco.id == espaco.tipoEspaco.id}"> selected</c:if>>${tipoEspaco.nome}</option>  
                                </c:forEach>
                            </select>
                        </td>
                        </tbody>


                    </table>
                    <br><br>
                    <input type="submit" onclick="return validar()" name="btnConfirmar"  class="btn btn-outline-primary" role="button" aria-pressed="true" value="Confirmar">

                    <a href="PesquisaEspacoController" class="btn btn-outline-danger" role="button" aria-pressed="true" value="Voltar">Voltar</a>

                </div>
            </form>

        </div> <!--FIM Div centralizadora-->







        <hr>

        <!--inicio Footer-->
        <%@ include file = "Footer.jsp" %>
        <!--fim Footer-->



    </body>
</html>
