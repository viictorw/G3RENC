
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Reserva" %>
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

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Pagamento - ${operacao}</title>



        <!-- JavaScript pasta ( js/scriptJSP.js  )-->
        <script language="javascript"  type="text/javascript" src="js/scriptJSP.js">
        </script>

        <!--inicio Header-->
        <%@ include file = "Header.jsp" %>
        <!--fim Header-->


    </head>
    <body>


        <div class="container">
            <div class="col-lg-12">
                <div>
                    <h1 class="text-center"> Pagamento - ${operacao} </h1> <hr>  <br><br>

                </div>
            </div>
            
                    <!-- INICIO TABELA-->

            <form name="form1" action="ManterPagamentoController?acao=confirmarOperacao&operacao=${operacao}" method="post">
                <table class="table table-striped">
                    <thead>
                    <tbody>
                    <br>

                    <tr>                            
                    <input type="HIDDEN" min="1" class="form-control" name="id" required id="id" value="${pagamento.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                        </tr>
                        
                        <tr>
                            <td>Vencimento: </td>
                            <td><input type="date" class="form-control" placeholder="00/00/0000" required="required"  maxlength="10" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$" autocomplete="off" min="1500-01-01" max="3000-12-31" name="txtVencimentoPagamento" value="${pagamento.vencimento}" required<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>   
                        
                        <tr>  
                            <td>Codigo de Barras: </td>
                            <td><input type="text" onkeyup="validare(this, 'numero')" class="form-control" required="required" maxlength="20" autocomplete="off" placeholder="Digite apenas números"name="txtCodBarrasPagamento" value="${pagamento.numeroCodBarras}" required<c:if test="${operacao == 'Excluir'}">readonly</c:if>></td>
                        </tr>
                        
                        <tr>
                            <td>Valor Total: </td>
                            <td><input type="text"onkeyup="validare(this, 'numero')" required="required"  class="form-control" maxlength="7" placeholder="R$ 00"  autocomplete="off"name="txtValorTotalPagamento" value="${pagamento.valorTotal}" required<c:if test="${operacao == 'Excluir'}">readonly</c:if>></td>
                        </tr> 

                        <tr>
                            <td>Reserva:</td>


                            <td>
                                <select class="form-control" name="idReservas" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                    <option>Selecione uma opção</option>
                                <c:forEach items="${reservas}" var="reserva">
                                    <option value="${reserva.id}" <c:if test="${reserva.id == pagamento.reserva.id}"> selected</c:if>>${reserva.id}</option>  
                                </c:forEach>
                            </select>
                        </td>
                    </tr>

                    </tbody>
                </table>
                <input onclick="return funcPagamento()" type="submit" name="btnConfirmar"  class="btn btn-outline-primary" role="button" aria-pressed="true" value="Confirmar"/>

                <a href="PesquisaPagamentoController" class="btn btn-outline-danger" role="button" aria-pressed="true" value="Voltar">Voltar</a>


        </div>
    </form>
</div>
<br>



<hr>

<!--inicio Footer-->
<%@ include file = "Footer.jsp" %>
<!--fim Footer-->




</body>
</html>