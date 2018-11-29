using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Calculator
{
    class Exponentation : UnaryOperation
    {
        public double x;

        public Exponentation(double x)
        {
            this.x = x;
        }

        public override double Evaluate()
        {
            return Math.Exp(x);
        }

        public override string Result()
        {
            return $"e^{x}";
        }
    }
}
