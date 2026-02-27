<%@ page import="java.util.*,br.edu.ifpb.bd.model.AbastecimentoLoja" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Total Recebido por Loja</title>
    <link rel="stylesheet" href="css/estiloPaginaListagem.css">
</head>
<body>
    <a href="consultas.jsp" class="estiloBotaoLink">Voltar para a Pagina Inicial</a>
    <h2>Total Recebido por Loja</h2>

    <table class="tabela-listagem">
        <thead>
            <tr>
                <th>ID Loja</th>
                <th>Cidade</th>
                <th>Total Recebido</th>
            </tr>
        </thead>
        <tbody>
            <% for (AbastecimentoLoja a:(List<AbastecimentoLoja>)request.getAttribute("listaTotalLoja")) { %>
                <tr>
                    <td><%=a.getId_loja()%></td>
                    <td><%=a.getCidade()%></td>
                    <td><%=a.getTotal_recebido()%></td>
                </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>