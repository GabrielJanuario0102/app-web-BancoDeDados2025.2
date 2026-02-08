<%@ page import="br.edu.ifpb.bd.model.Armazem" %>
<%
Armazem armazem = (Armazem) request.getAttribute("armazem");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Armazem</title>
    <link rel="stylesheet" href="css/estiloPaginaEditar.css">
</head>
<body>
    <h2>Cadastrar Armazem</h2>
    <!-- The "action" attribute should point to your server-side processing script -->
    <form action="EditarArmazem" method="POST">
        
        <input type="hidden" name="id_armazem" value="<%= armazem!=null?armazem.getId():"" %>">

        <label for="estado">Estado:</label>
        <input type="text" id="estado" name="estado" value="<%= armazem.getEstado() %>" required>

        <label for="cidade">Cidade:</label>
        <input type="text" id="cidade" name="cidade" value="<%= armazem.getCidade() %>"  required>

        <label for="numero">Numero:</label>
        <input type="text" id="numero" name="numero" value="<%= armazem.getNumero() %>"  required>

        <br /> <br />
        <input type="submit" value="Atualizar">
        &nbsp; &nbsp;
        <a href="ListarArmazem">Cancelar</a>
    </form>
</body>
</html>