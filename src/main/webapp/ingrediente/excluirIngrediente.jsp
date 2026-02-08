<%@ page import="br.edu.ifpb.bd.model.Ingrediente" %>
<%
Ingrediente ingrediente = (Ingrediente) request.getAttribute("ingrediente");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Excluir Ingrediente</title>
    <link rel="stylesheet" href="css/estiloPaginaExcluir.css">
</head>
<body>
    <h2>Realmente deseja excluir?</h2>
    <!-- The "action" attribute should point to your server-side processing script -->
    <form action="ExcluirIngrediente" method="POST">
        
        <input type="hidden" name="id_ingrediente" value="<%= ingrediente!=null?ingrediente.getId():"" %>">

        <label for="nome">Nome:</label>
        <span><%= ingrediente.getNome() %></span>
        
        <br /> <br />
        
        <label for="tipo_medida">Tipo de Medida:</label>
        <span><%= ingrediente.getTipo_medida() %></span>

        <br /> <br />
        <input type="submit" value="Excluir">
        &nbsp; &nbsp;
        <a href="ListarIngrediente">Cancelar</a>
    </form>
</body>
</html>