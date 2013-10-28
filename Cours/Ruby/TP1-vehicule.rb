puts '________________________________'
puts
puts 'Exercice 15'
puts
module Vehicules
class Vehicule
	def  initialize (id,capacite_charge, vitesse_max)
		@id=id
		@capacite_charge=capacite_charge
		@vitesse_max=vitesse_max
	end
	def afficher ()
		puts "Vehicule : #{@id.to_s} a une Capacite de charde : #{@capacite_charge.to_s} et une Vitesse max : #{@vitesse_max.to_s}"
	end
end

class AMoteur < Vehicule
	def initialize (emission,consommation,distance,id,capacite,vitesse_max)
		super(id,capacite,vitesse_max)
		@emission = emission
		@consommation = consommation
		@distance = distance
	end
	def afficher ()
		super
		puts "==> A Moteur / emission : #{@emission.to_s} / consommation : #{@consommation.to_s} / distance 100l : #{@distance.to_s}"
	end
end

class Ecolo < Vehicule
	def initialize (nom,dimension,id,capacite,vitesse_max)
		super(id,capacite,vitesse_max)
		@nom = nom
		@dimension=dimension
	end
	def afficher ()
		super
		puts "==> Ecolo / Nom : #{@nom.to_s} / dimension : #{@dimension.to_s}"
	end
end

class Voilier < Ecolo
	def initialize (surface_voile)
		super(nom,dimension)
		@surface_voile=surface_voile
	end
	def afficher ()
		super
		puts "==> Surface des voile : #{@surface_voile.to_s}"
	end
end

class Kayak < Ecolo
	def initialize (type)
		super(nom,dimension)
		@type=type
	end
	def afficher ()
		super
		puts "==> Type : #{@type.to_s}"
	end
end

class Bateau < AMoteur
	def initialize (passager)
		super(emission,consommation,distance)
		@passager=passager
	end
	def afficher ()
		super
		puts "==> Nombre de passager : #{@passager.to_s}"
	end
end

class Terrestre < AMoteur
	def initialize (marque,immatriculation,emission,consommation,distance,id,capacite,vitesse_max)
		super(emission,consommation,distance,id,capacite,vitesse_max)
		@marque=marque
		@immatriculation=immatriculation
	end
	def afficher ()
		super
		puts "==> Marque Vehicule Terrestre : #{@marque.to_s} avec immatriculation :  #{@immatriculation.to_s}"
	end
end

class Voiture < Terrestre
	def initialize (passagervoit,marque,immatriculation,emission,consommation,distance,id,capacite,vitesse_max)
		super(marque,immatriculation,emission,consommation,distance,id,capacite,vitesse_max)
		@passagervoit=passagervoit
	end
	def afficher ()
		super
		puts "==> Passager: #{@passagervoit.to_s}"
	end
end

class Camion < Terrestre
	def initialize (nb_remorque,marque,immatriculation,emission,consommation,distance,id,capacite,vitesse_max)
		super(marque,immatriculation,emission,consommation,distance,id,capacite,vitesse_max)
		@nb_remorque=nb_remorque
	end
	def afficher ()
		super
		puts "==> Remorque max: #{@nb_remorque.to_s}"
	end
end
end


