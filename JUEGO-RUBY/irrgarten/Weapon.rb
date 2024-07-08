require_relative 'Dice'
require_relative 'CombatElement'
module Irrgarten
    class Weapon < CombatElement
        def attack
            return self.produce_effect
        end
        def to_s()
            return "W" + super
        end
    end
end

