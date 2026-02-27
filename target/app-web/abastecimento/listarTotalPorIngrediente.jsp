<%@ page import="java.util.*,br.edu.ifpb.bd.model.AbastecimentoLoja" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Total por Ingrediente</title>
    <link rel="stylesheet" href="css/estiloPaginaListagem.css">
</head>
<body>
    <a href="consultas.jsp" class="estiloBotaoLink">Voltar para a Pagina Inicial</a>
    <h2>Total Abastecido por Ingrediente</h2>

    <table class="tabela-listagem">
        <thead>
            <tr>
                <th>Ingrediente</th>
                <th>Total Abastecido</th>
            </tr>
        </thead>
        <tbody>
            <% for (AbastecimentoLoja a:(List<AbastecimentoLoja>)request.getAttribute("listaTotalIngrediente")) { %>
                <tr>
                    <td><%=a.getIngrediente()%></td>
                    <td><%=a.getTotal_abastecido()%></td>
                </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>