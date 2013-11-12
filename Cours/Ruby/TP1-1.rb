=begin
chaine1 = 'coucou'
chaine2 = 'aurevoir'

puts chaine1
puts chaine2

puts chaine1.upcase
puts chaine1.downcase
puts chaine1.swapcase

puts chaine2.center(15)
puts chaine2.ljust(15)
puts chaine2.rjust(15)

puts 'Table des matieres'
puts 'Chapitre1 :'.ljust(10)+'Nombres'.center(30)+'1'.rjust(10)
puts 'Chapitre2 :'.ljust(10)+'Lettres'.center(30)+'72'.rjust(10)
puts 'Chapitre3 :'.ljust(10)+'Variables'.center(30)+'118'.rjust(10)
puts ' '

puts 'Exercice 2'
a=(1..1000)
b=0
a.each do |i|
	b+=i
end
puts b
puts
puts 'Exercice 3'
puts 'saisissez une phrase : '
ph = gets.chomp
puts 'saisissez un nombre : '
ent = gets.chomp.to_i
puts 'execution'
ent.times do
	puts ph
end
puts

puts 'Exercice 4'
puts 'annee debut:'
an_deb = gets.chomp.to_i
puts 'annee fin:'
an_fin = gets.chomp.to_i

for i in (an_deb..an_fin) do
	if i%400==0 or (i%4==0 and i%100!=0)
		puts i
	end
end


puts 'Exercice 5'
tab = [1,2,3,9,'a','b','c']
puts 'saisir : '
nb = gets.chomp
for i in (tab) do
	if (i.to_s>nb.to_s)
		puts i
	end
end

puts 'Exercice 6'
tab1 = [1,32,25,69,9,5,7]
puts tab1.sort.inspect



puts 'Exercice 7'
tab2 = [1,32,25,69,9,5,7,'a','bout','ok','poux']
tab3=tab2.collect do |i| i.to_s end
tab3=tab3.sort
puts tab3.inspect
puts 'Truc + grand ='
puts tab3[-1]

somme = 0
phrase = ''
for i in (tab2) do
	if i.is_a? Integer then
		somme+=i
	end
	if i.is_a? String then
		phrase+=i+' ' 
	end
end
puts 'Somme: ' + somme.to_s
puts 'Concatenation: ' + phrase


 
puts 'Exercice 9'

adresses = [ 
 [ 17, "Boulevard de la Sauveniere" ], 
 [ 2, "Place de la Republique Francaise"], 
 [ 19, "Rue de la Renaissance"] 
]
puts adresses.sort
puts 'Essai 2'
adresses1 = [ 
 [ 20, "Rue de la Renaissance" ], 
 [ 20, "Place de la Republique Francaise"] 
]

puts adresses1.sort


puts 'Exercice 10'

noms = ["laurent", "david", "stefanie", "laura"]
t1 = noms.collect{|x| x.capitalize}
puts t1
puts 'Autre méthode avec each'


puts 'Exercice 11'

contact1 = {
 "prenom" =>"Sacha",
 "nom de famille" =>"MINARD",
 "adresse" =>"1504, Route de Chambéry",
 "ville" =>"Sain-Ismier",
 "province" =>"Isere",
 "code postal" => 38330
}
contact2 = {
 "prenom" =>"OK",
 "nom de famille" =>"Psk",
 "adresse" =>"Rue de la mairie, 41",
 "ville" =>"Nice",
 "province" =>"Alpes",
 "code postal" => 06000
}
contact3 = {
 "prenom" =>"Jean",
 "nom de famille" =>"Pafeur",
 "adresse" =>"Rue de l'eglise, 92",
 "ville" =>"VilleMonde",
 "province" =>"World",
 "code postal" => 00000
}
carnet = [ contact1, contact2, contact3]
puts carnet.inspect
puts ''
puts '____Methode ajout contacts____'
puts ''
def ajout ()
	puts 'Saisir Prenom'
	prenom = gets
	puts 'Saisir Nom'
	nom = gets
	puts 'Saisir Adresse'
	adresse = gets
	puts 'Saisir Ville'
	ville = gets
	puts 'Saisir Province'
	province = gets
	puts 'Saisir cp'
	cp = gets
	contact = {
		:prenom => prenom,
		:nom => nom,
		:adresse => adresse,
		:ville => ville,
		:province => province,
		:cp => cp
	}
	return contact
end

carnet.push (ajout)
puts ''
puts '--Carnet--'
puts carnet.inspect
puts ''
puts '____Methode Affichage____'
puts ''

def affiche (carnet)
	carnet.each do |contact|
		puts
		puts 'nom		' + contact[:nom]
		puts 'prenom	' + contact[:prenom]
		puts 'adresse	' + contact[:adresse]
		puts 'ville		' + contact [:ville]
		puts 'province	' + contact[:province]
		puts 'cp		' + contact[:cp]
	end
end

carnet.affiche

=end



