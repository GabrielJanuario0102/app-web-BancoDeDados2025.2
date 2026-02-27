<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario Loja</title>
    <link rel="stylesheet" href="css/estiloPaginaCadastrar.css">
</head>
<body>
    <h2>Cadastrar Loja</h2>
    <!-- The "action" attribute should point to your server-side processing script -->
    <form action="CadastrarLoja" method="POST">

        <label>Matriz:</label>
        <input type="radio" id="matrizSim" name="matriz" value="true"> Sim
        <input type="radio" id="matrizNao" name="matriz" value="false"> Não

        <label for="estado">Estado:</label>
        <input type="text" id="estado" name="estado" required>

        <label for="cidade">Cidade:</label>
        <input type="text" id="cidade" name="cidade" required>

        <label for="numero">Numero:</label>
        <input type="text" id="numero" name="numero" required>

        <br /> <br />
        <input type="submit" value="Cadastrar">
    </form>
</body>
</html>