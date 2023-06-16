<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="author" content="Juan Bautista">
    <meta name="description" content="Formulario para el regsitro de productos en RICK.">
    <meta name="keywords" content="registro de productos, formulario de registro, crear , registro en linea">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Formulario De Registro De Categorias RICK</title>
    <link rel="icon" type="image/x-icon" href="../img/icons8-rick-sanchez-64.png">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.4/font/bootstrap-icons.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/reC.css">
</head>
<body class="text-center">
<main class="form-signin w-100 m-auto">
    <form action="" method="post">
        <img class="mb-4" src="${pageContext.request.contextPath}/img/icons8-rick-sanchez-64.png" alt="RICK" width="100">
        <h4 class="text-secondary">RICK</h4>
        <h1 class="h5 mb-3 fw-normal">Registro de Categorias</h1>

        <div class="form-floating">
            <input type="text" class="form-control" id="floatingName"
                   placeholder="Ingrese el nombre de la caegoria" required autofocus
                   pattern="[A-za-z]{3,15}">
            <label for="floatingName">Nombre:</label>
        </div>

        <button class="w-100 btn btn-lg btn-info" type="submit">Registrar</button>

        </div>
        <br>
        <jsp:include page="templates/footer.jsp"></jsp:include>

    </form>
</main>
</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>



</div>
</body>
</html>