<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario Ingrediente</title>
    <link rel="stylesheet" href="css/estiloPaginaCadastrar.css">
</head>
<body>
    <h2>Cadastrar Ingrediente</h2>
    <!-- The "action" attribute should point to your server-side processing script -->
    <form action="CadastrarIngrediente" method="POST" class="">

        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required>

        <label for="tipo_medida">Tipo de medida:</label>
        <input type="text" id="tipo_medida" name="tipo_medida" required>

        <br /> <br />
        <input type="submit" value="Cadastrar">
    </form>
</body>
</html>