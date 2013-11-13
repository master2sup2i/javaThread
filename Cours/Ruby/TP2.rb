=debut
*********************************
=end

def Test (s)

begin

	while (i<s.length)
		if (s[i].to_s!=s[i])
			raise MonErreur "Mauvaise chaine.."
		end
		i=i+1 
	end
	rescue MonErreur => e
		puts e 'Saisissez une nouvelle avec des chiffres !!'		
		ch = gets.chomp
		puts ch
		s[1]=ch
		retry
			else
				return s
	end
end

s=gets.chomp
puts Test(s)

=begin
s=0
f = File.new("myfile.txt", "w")
lines=f.readlines()
lines.each{|line|print|{line}
s=s+line.to_i
}
f.close
puts s
*************hello World****************
=end



