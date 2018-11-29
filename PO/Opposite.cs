using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Calculator
{
    class Opposite : UnaryOperation
    {
        public double value;

        public Opposite(double value)
        {
            this.value = value;
        }

        public override double Evaluate()
        {
            return -value;
        }

        public override string Result()
        {
            return $"-{value}";
        }
    }
}
