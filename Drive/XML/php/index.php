<?php
$xslt = new XSLTProcessor();
// Chargement du fichier XML
$xml = new domDocument();
$xml -> load('cours.xml');
// Chargement du fichier XSL
$xsl = new domDocument();
$xsl -> load('cours.xslt');
// Import de la feuille XSL
$xslt -> importStylesheet($xsl);
// Transformation et affichage du résultat
echo $xslt -> transformToXml($xml);
