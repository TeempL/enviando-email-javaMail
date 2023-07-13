<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/styless.css">
</head>
<body>
<div class="contact1">
		<div class="container-contact1">
			<div class="contact1-pic js-tilt" data-tilt>
				<img src="resources/img/img-01.png" alt="IMG">
			</div>

			<form class="contact1-form validate-form" action="javaMail" method="post">
				<span class="contact1-form-title">
					Entrar em contato
				</span>
				<span style="color: green" class="contact1-form-title">
					${msg}
				</span>

				<div class="wrap-input1 validate-input" >
					<input class="input1" type="text" name="nome" required="required" placeholder="Nome de quem esta enviando">
					<span class="shadow-input1"></span>
				</div>

				<div class="wrap-input1 validate-input">
					<input class="input1" type="email" name="email" required="required" placeholder="Email: Destinatario">
					<span class="shadow-input1"></span>
				</div>

				<div class="wrap-input1 validate-input" >
					<input class="input1" type="text" name="titulo"  required="required" placeholder="Titulo do email">
					<span class="shadow-input1"></span>
				</div>

				<div class="wrap-input1 validate-input">
					<textarea class="input1" name="mensagem" required="required" placeholder="Mensagem"></textarea>
					<span class="shadow-input1"></span>
				</div>

				<div class="container-contact1-form-btn">
					<button class="contact1-form-btn">
						<span>
							Enviar Email
							<i class="fa fa-long-arrow-right" aria-hidden="true"></i>
						</span>
					</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>