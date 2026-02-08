<%@ page import="br.edu.ifpb.bd.model.Armazem" %>
<%
Armazem armazem = (Armazem) request.getAttribute("armazem");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Excluir Armazem</title>
    <link rel="stylesheet" href="css/estiloPaginaExcluir.css">
</head>
<body>
    <h2>Realmente deseja excluir?</h2>
    <!-- The "action" attribute should point to your server-side processing script -->
    <form action="ExcluirArmazem" method="POST">
        
        <input type="hidden" name="id_armazem" value="<%= armazem!=null?armazem.getId():"" %>">

        <label for="estado">Estado:</label>
        <span><%= armazem.getEstado() %></span>
        
        <br /> <br />
        
        <label for="cidade">Cidade:</label>
        <span><%= armazem.getCidade() %></span>

        <br /> <br />
        
        <label for="numero">Numero:</label>
        <span><%= armazem.getNumero() %></span>

        <br /> <br />
        <input type="submit" value="Excluir">
        &nbsp; &nbsp;
        <a href="ListarArmazem">Cancelar</a>
    </form>
</body>
</html>