<%@ page import="java.util.*,br.edu.ifpb.bd.model.Loja" %>
<!DOCTYPE html>
    <html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <title>Lista Lojas</title>
        <link rel="stylesheet" href="css/estiloPaginaListagem.css">
    </head>

    <body>
        <a href="/app-web" class="estiloBotaoLink">Voltar para a Pagina Inicial</a>

        <h2>Listagem de Lojas</h2>

        <table class="tabela-listagem">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Matriz</th>
                    <th>Estado</th>
                    <th>Cidade</th>
                    <th>Numero</th>
                </tr>
            </thead>
            <tbody>
                <% for (Loja loja:(List<Loja>)request.getAttribute("lojas")) { %>
                    <tr>
                        <td>
                            <%=loja.getId()%>
                        </td>
                        <td>
                            <%=loja.getMatriz()%>
                        </td>
                        <td>
                            <%=loja.getEstado()%>
                        </td>
                        <td>
                            <%=loja.getCidade()%>
                        </td>
                        <td>
                            <%=loja.getNumero()%>
                        </td>
                        <td>
                            <a href="EditarLoja?id_loja=<%=loja.getId()%>"
                                class="linkEditar">Editar</a>
                            &nbsp;
                            <a href="ExcluirLoja?id_loja=<%=loja.getId()%>"
                                class="linkExcluir">Excluir</a>
                        </td>
                    </tr>
                    <% } %>
            </tbody>
        </table>
    </body>
    </html>