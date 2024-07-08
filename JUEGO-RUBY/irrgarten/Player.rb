require_relative 'Weapon'
require_relative 'Shield'
require_relative 'Dice'
require_relative 'LabyrinthCharacter'
module Irrgarten
    class Player < LabyrinthCharacter
        @@MAX_WEAPONS = 2
        @@MAX_SHIELDS = 3
        @@INITIAL_HEALTH = 5
        @@HITS2LOSE = 3
        attr_reader :shields , :weapons ,:consecutive_hits , :number
        #Constructor de la clase 
        #number: char
        #intelligence: float
        #strenght: float
        def initialize(number , intelligence , strenght)
            @number = number
            super("Player #@number",intelligence,strenght,@@INITIAL_HEALTH)
            @consecutive_hits = 0
            @weapons = Array.new()
            @shields = Array.new()
        end
        def copy(other)
            super(other)
            @number = other.number
            @consecutive_hits = other.consecutive_hits
            @weapons = other.weapons
            @shields = other.shields

        end
        #Se encarga de reseterar al jugador quitanfdole las armas y devolviendole 
        #la vida inicial
        def resurrect
            @weapons.clear 
            @shields.clear
            @health = @@INITIAL_HEALTH
            @consecutive_hits = 0
        end

        def move(direction , valid_moves)
            if(valid_moves.size > 0) && !(valid_moves.include?(direction))
                return valid_moves[Dice.random_pos(valid_moves.size)]
            else
                return direction
            end
        end
        def to_s
            return super + @weapons.to_s
        end


        #Calcula el ataque del jugador sumando su fuerza y el poder de sus armas
        def attack
            return @strenght + self.sum_weapons()
        end
        #Calcula la defensa del jugador delegando 
        #en el metodo manage_hit 
        def defend(recieved_attack)
            return manage_hit(recieved_attack)
        end

        def recieve_reward()
            w_reward = Dice.weapons_reward
            s_reward = Dice.shields_reward
            for i in 0...w_reward
                self.recieve_weapon(self.new_weapon)
            end
            for i in 0...s_reward
                self.recieve_shield(self.new_shield)
            end
            @health += Dice.health_reward
        end




        ##METODOS PRIVADOS##
        
        private

        def recieve_shield(s)
            for si in @shields
                if si.discard
                    @shields.delete(si)
                end
            end
            if(@shields.size < @@MAX_SHIELDS)
                @shields.push(s)
            end        
        end
        def recieve_weapon(w)
            for we in @weapons
                if we.discard()
                    @weapons.delete(we)
                end
            end
            if(@weapons.size < @@MAX_WEAPONS)
                @weapons.push(w)
            end
        end
        #Crea un nuevo objeto weapon usando valores aleatorios de la clase Dice
        def new_weapon
            return Weapon.new(Dice.weapon_power,Dice.uses_left)
        end
        #Crea un nuevo objeto shield usando valores aleatorios de la clase Dice
        def new_shield
            return Shield.new(Dice.weapon_power,Dice.uses_left)
        end
        #Suma el valor de ataque de las armas del jugador 
        def sum_weapons
            total = 0
            for arma in @weapons do
                total+=arma.attack
            end
            return total
        end
        #suma el valor de proteccion de los escudos del jugador
        def sum_shields
            total = 0
            for escudos in @shields do
                total +=escudos.protect
            end
            return total
        end
        def defensive_energy
            sum = @intelligence + self.sum_shields
            return sum
        end
        def manage_hit(recievad_attack)
            defense =self.defensive_energy
            if defense < recievad_attack
                self.got_wounded
                self.inc_consecutive_hits
            else
                self.reset_hits
            end
            if ((@consecutive_hits == @@HITS2LOSE) || self.dead)
                self.reset_hits
                return true
            else
                return false
            end
        end
        
        def reset_hits
            @consecutive_hits = 0
        end

        #incrementa en 1 la cantidad de golpes consecutivos que ha recibido el jugador
        def inc_consecutive_hits
            @consecutive_hits+=1
        end
    end 
end

