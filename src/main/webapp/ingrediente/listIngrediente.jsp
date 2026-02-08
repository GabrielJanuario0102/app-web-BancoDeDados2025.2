<%@ page import="java.util.*,br.edu.ifpb.bd.model.Ingrediente" %>
    <!DOCTYPE html>
    <html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <title>Lista Ingredientes</title>
        <link rel="stylesheet" href="css/estiloPaginaListagem.css">
    </head>

    <body>
        <a href="/app-web" class="estiloBotaoLink">Voltar para a Pagina Inicial</a>

        <h2>Listagem de Ingredientes</h2>

        <table class="tabela-listagem">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Tipo De Medida</th>
                </tr>
            </thead>
            <tbody>
                <% for (Ingrediente ingrediente:(List<Ingrediente>)request.getAttribute("ingredientes")) { %>
                    <tr>
                        <td>
                            <%=ingrediente.getId()%>
                        </td>
                        <td>
                            <%=ingrediente.getNome()%>
                        </td>
                        <td>
                            <%=ingrediente.getTipo_medida()%>
                        </td>
                        <td>
                            <a href="EditarIngrediente?id_ingrediente=<%=ingrediente.getId()%>"
                                class="linkEditar">Editar</a>
                            &nbsp;
                            <a href="ExcluirIngrediente?id_ingrediente=<%=ingrediente.getId()%>"
                                class="linkExcluir">Excluir</a>
                        </td>
                    </tr>
                    <% } %>
            </tbody>
        </table>

                <script src="/projeto/js/bootstrap.bundle.min.js">
        </script>
    </body>
    </html>