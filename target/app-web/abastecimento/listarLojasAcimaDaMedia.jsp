<%@ page import="java.util.*,br.edu.ifpb.bd.model.AbastecimentoLoja" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Lojas Acima da Média</title>
    <link rel="stylesheet" href="css/estiloPaginaListagem.css">
</head>
<body>
    <a href="consultas.jsp" class="estiloBotaoLink">Voltar para a Pagina Inicial</a>
    <h2>Lojas Acima da Média de Abastecimento</h2>

    <table class="tabela-listagem">
        <thead>
            <tr>
                <th>ID Loja</th>
                <th>Cidade</th>
                <th>Total Recebido</th>
            </tr>
        </thead>
        <tbody>
            <% for (AbastecimentoLoja a:(List<AbastecimentoLoja>)request.getAttribute("listaAcimaMedia")) { %>
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