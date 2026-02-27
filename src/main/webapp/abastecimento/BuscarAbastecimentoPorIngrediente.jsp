<%@ page import="java.util.*,br.edu.ifpb.bd.model.AbastecimentoLoja" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Buscar por Ingrediente</title>
    <link rel="stylesheet" href="css/estiloPaginaListagem.css">
</head>
<body>

<a href="consultas.jsp" class="estiloBotaoLink">Voltar para a Pagina Inicial</a>

<h2>Buscar Abastecimentos por Ingrediente</h2>

<!-- Barra de Pesquisa -->
<form method="get" action="BuscarPorIngrediente">
    <input type="text" name="nomeIngrediente" 
           placeholder="Digite o nome do ingrediente" required>
    <button type="submit">Pesquisar</button>
</form>

<br>

<table class="tabela-listagem">
    <thead>
        <tr>
            <th>ID Abastecimento</th>
            <th>ID Loja</th>
            <th>ID Armazém</th>
            <th>Ingrediente</th>
            <th>Estado da Loja</th>
        </tr>
    </thead>
    <tbody>
        <%
        List<AbastecimentoLoja> lista =
            (List<AbastecimentoLoja>) request.getAttribute("lista");

        if (lista != null) {
            for (AbastecimentoLoja a : lista) {
        %>
            <tr>
                <td><%=a.getId_abastecimento()%></td>
                <td><%=a.getId_loja()%></td>
                <td><%=a.getId_armazem()%></td>
                <td><%=a.getIngrediente()%></td>
                <td><%=a.getLocal_loja()%></td>
            </tr>
        <%
            }
        }
        %>
    </tbody>
</table>

</body>
</html>