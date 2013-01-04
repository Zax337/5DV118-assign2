addi $t0, $t1, 4
addi $t1, $zero, 1
sw 	$t0, ($zero)
sub $t0, $t0, $t1
slt $t4, $t0, $t1
beq $zero,$t4, -4
addi $t0, $t1, 8
sw $t0, 4($zero)
lw 	$t3, 4($zero)
and $t4, $t3, $t1
add $t0,$t1,$t4
beq $t1,$t4, 2
sub $t0,$t1,$t2
and $t0,$t1,$t2
or $t0,$t1,$t2
nor $t0,$t1,$t2
slt $t0,$t1,$t2
nop
exit
