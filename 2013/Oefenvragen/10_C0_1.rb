# 10_C0_1: MinMax
for i in 1..STDIN.readline.to_i
    n = STDIN.readline.to_i-1
    nummers=Array.new(n)
    for i in (0..n)
        nummers[i]=STDIN.readline.to_i
    end
    minimum=nummers.min
    maximum=nummers.max
    puts "#{minimum} #{maximum}"
end