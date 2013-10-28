<?php
function initializeSEssion()
{
	$_SESSION['essais'] = 5;
	$_SESSION['devine'] = rand(0,100);
}


session_start();
if(!isset($_SESSION['essais']) 
	|| !isset($_SESSION['devine']) )
{
	initializeSEssion();
}
?>

<html>
	<head>
	</head>
	<body>
		<form id="form1" method="post">
			<input type="text" name="nombre"/>
			<input type="submit" value="Envoyer" />
		</form>
	
	<p>
	<?php
$nombreadevine = $_SESSION['devine'];
if(isset($_POST["nombre"]))
{
	$nb = $_POST["nombre"];
	if(is_numeric($nb))
	{
		if($nb == $nombreadevine)
		{
			echo "bravo, vous avez trouvé! c'était bien : ".$nb;
			initializeSEssion();
		}
		elseif($nb<$nombreadevine)
		{
			echo "le nombre a deviné est plus grand que ".$nb;
			$_SESSION['essais']--;
		}
		else
		{
			echo "le nombre a deviné est plus petit que ".$nb;	
			$_SESSION['essais']--;	
		}
		if($_SESSION['essais'] == 0)
		{
			echo "Vouz avez perdu";
			initializeSEssion();
		}
	}
	else
	{
		echo "ce n'est pas un nombre";
	}
}

?>
	</p>
	</body>
</html>