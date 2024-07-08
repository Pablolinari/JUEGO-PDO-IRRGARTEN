require_relative 'Dice'
require_relative 'LabyrinthCharacter'
module Irrgarten
    class Monster < LabyrinthCharacter
        @@INITIAL_HEALTH = 5
        def initialize(name, intelligence , strenght)
            super(name,intelligence,strenght,@@INITIAL_HEALTH)
        end
        
        def attack
            return Dice.intensity(@strenght)
        end
        def defend(recieved_attack)
            is_dead = self.dead
            if(!is_dead)
                defensive_energy = Dice.intensity(@intelligence)
                if(defensive_energy < recieved_attack)
                    self.got_wounded
                    is_dead = self.dead
                end
            end
            return is_dead

        end

    end
end
