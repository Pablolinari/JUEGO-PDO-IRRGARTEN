require_relative 'Player'
require_relative 'Dice'


module Irrgarten
    class FuzzyPlayer < Player 
        def initialize(number,intelligence,strenght)
            super(number,intelligence,strenght)
        end
        def move(direction,validMoves)
            preferred = super(direction, validMoves)
            return Dice.next_step(preferred, validMoves, self.intelligence)
        end
       # def move(direction,validMoves)
            #preferred = super(direction,validMoves)
        #end
        def attack 
            return self.sum_weapons + Dice.intensity(self.strenght)
        end
        def defensiveEnergy
            self.sum_shields + Dice.intensity(self.intelligence)
        end
        def to_s
            return "Fuzzy " + super
        end
    end
end
