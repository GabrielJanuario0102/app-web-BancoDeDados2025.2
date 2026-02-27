<%@ page import="java.util.*,br.edu.ifpb.bd.model.AbastecimentoLoja" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Lojas e Abastecimentos</title>
    <link rel="stylesheet" href="css/estiloPaginaListagem.css">
</head>
<body>
    <a href="consultas.jsp" class="estiloBotaoLink">Voltar para a Pagina Inicial</a>
    <h2>Lojas com Abastecimento</h2>

    <table class="tabela-listagem">
        <thead>
            <tr>
                <th>ID Loja</th>
                <th>Cidade</th>
                <th>ID Abastecimento</th>
                <th>Quantidade</th>
            </tr>
        </thead>
        <tbody>
            <% for (AbastecimentoLoja a:(List<AbastecimentoLoja>)request.getAttribute("listaLojasAbastecimento")) { %>
                <tr>
                    <td><%=a.getId_loja()%></td>
                    <td><%=a.getCidade()%></td>
                    <td><%=a.getId_abastecimento()%></td>
                    <td><%=a.getQuantidade_ingrediente()%></td>
                </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>