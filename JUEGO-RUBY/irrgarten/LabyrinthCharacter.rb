module Irrgarten
    class LabyrinthCharacter
        attr_reader :intelligence,:row, :col, :intelligence, :strenght ,:name
        attr_accessor :health
        def initialize(name,intelligence,strenght,health)
            @name = name
            @intelligence = intelligence
            @strenght = strenght
            @health = health
            @row=0
            @col=0
        end
        def copy(other)
            @name = other.name
            @intelligence = other.intelligence
            @strenght = other.strenght
            @health = other.health
            @col = other.col
            @row = other.row

        end
        #Devuelve true si el jugador esta muerto
        def dead
            return @health <=0
        end
        #Establece la posicion del jugador 
        def set_pos(row , col)
            @row = row
            @col = col 
        end
        #Muestra los atributos del jugador en formato string
        def to_s
            return "[#@name,H:#@health,I:#@intelligence,S:#@strenght,pos(#@row,#@col)]"
        end
        #decrementa en 1 la salud del jugador 
        def got_wounded
            if @health >1
                @health -=1
            else
                @health = 0
            end
        end


    end
end
