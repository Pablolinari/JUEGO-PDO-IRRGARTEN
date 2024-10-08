module Irrgarten
    class Dice
        @@MAX_USES = 5
        @@MAX_INTELLIGENCE = 10.0
        @@MAX_STRENGTH = 10.0
        @@RESURRECT_PROB = 0.3
        @@WEAPONS_REWARD = 2
        @@SHIELDS_REWARD = 3
        @@HEALTH_REWARD = 5
        @@MAX_ATTACK = 3.0
        @@MAX_SHIELD = 2.0
        @@generator = Random.new()
        
        def self.random_pos(max)
            return @@generator.rand(max)
        end

        def self.who_starts(nplayers)
            return @@generator.rand(nplayers)
        end

        def self.random_intelligence()
            return @@generator.rand(@@MAX_INTELLIGENCE)
        end
        
        def self.random_strength()
            return @@generator.rand(@@MAX_STRENGTH)
        end

        def self.resurrect_player()
            if @@generator.rand(0.0..1.0) > @@RESURRECT_PROB then
                return false
            else
                return true
            end
        end

        def self.weapons_reward()
            return @@generator.rand(0..@@WEAPONS_REWARD)
        end
        
        def self.shields_reward()
            return @@generator.rand(@@SHIELDS_REWARD)
        end

        def self.health_reward()
            return @@generator.rand(@@HEALTH_REWARD)
        end

        def self.weapon_power()
            return @@generator.rand(0..@@MAX_ATTACK)
        end

        def self.shield_power()
            return @@generator.rand(0..@@MAX_SHIELD)
        end

        def self.uses_left()
            return @@generator.rand(@@MAX_USES)
        end
        
        def self.intensity(competence)
            return @@generator.rand(0.0 ..1.0) * competence
        end

        def self.discard_element(uses_left)
            prob = uses_left.to_f/@@MAX_USES
            return (@@generator.rand(0.0..1.0)>= prob)
        end
        def self.next_step(preference,valid_moves,intelligence)
            prob = intelligence/@@MAX_INTELLIGENCE
            if @@generator.rand(0.0..1.0)<= prob
                return preference
            else
                return valid_moves[self.random_pos(valid_moves.size)]
            end
        end
    end
end


    



