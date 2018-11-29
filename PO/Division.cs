using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Calculator
{
    class Division : BinaryOperation
    {
        public double x;
        public double y;

        public Division(double x, double y)
        {
            this.x = x;
            this.y = y;
        }
        public override double Evaluate()
        {
            return x / y;
        }

        public override string Result()
        {
            return $"{x}/{y}";
        }
    }
}
