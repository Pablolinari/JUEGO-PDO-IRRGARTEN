require_relative 'Dice'
module Irrgarten
    class Shield < CombatElement
        def protect()
            return self.produce_effect
        end
        def to_s()
            return "S" + super
        end
    end
end


     
