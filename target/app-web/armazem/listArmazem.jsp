<%@ page import="java.util.*,br.edu.ifpb.bd.model.Armazem" %>
    <!DOCTYPE html>
    <html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <title>Lista Armazens</title>
        <link rel="stylesheet" href="css/estiloPaginaListagem.css">
    </head>

    <body>

        <a href="/app-web" class="estiloBotaoLink">Voltar para Página Inicial</a>

        <h2>Listagem de Armazens</h2>

        <table class="tabela-listagem">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Estado</th>
                    <th>Cidade</th>
                    <th>Numero</th>
                </tr>
            </thead>
            <tbody>
                <% for(Armazem armazem:(List<Armazem>)request.getAttribute("armazens")){ %>
                    <tr>
                        <td>
                            <%=armazem.getId()%>
                        </td>
                        <td>
                            <%=armazem.getEstado()%>
                        </td>
                        <td>
                            <%=armazem.getCidade()%>
                        </td>
                        <td>
                            <%=armazem.getNumero()%>
                        </td>
                        <td>
                            <a href="EditarArmazem?id_armazem=<%=armazem.getId()%>" class="linkEditar">Editar</a>
                            &nbsp;
                            <a href="ExcluirArmazem?id_armazem=<%=armazem.getId()%>" class="linkExcluir">Excluir</a>
                        </td>
                    </tr>
                    <% } %>
            </tbody>
        </table>

    </body>

    </html>