def showFamily( aClass )
	if (aClass != nil) then
	
end

end

def chDisk( aChar )

	startdir = Dir.getwd

begin

	rescue Exception => e

this...

puts( "#{aClass}" )

showFamily( aClass.superclass )

Dir.chdir( "#{aChar}:\\" )

puts( `dir` )

# showFamily( e.class ) # to see ancestors, uncomment 

puts e.class # ...and comment out this

puts e

Dir.chdir( startdir )

ensure

end

end

chDisk( "D" )

chDisk( "X" )

chDisk( "ABC" )